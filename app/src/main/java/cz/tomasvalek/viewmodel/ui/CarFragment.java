package cz.tomasvalek.viewmodel.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import cz.tomasvalek.viewmodel.R;
import cz.tomasvalek.viewmodel.model.Car;
import cz.tomasvalek.viewmodel.viewmodel.CarViewModel;

public class CarFragment extends Fragment {

	private static final String TAG = CarFragment.class.getSimpleName();

	private CarViewModel mViewModel;

	private EditText name;
	private EditText fuel;

	public static CarFragment newInstance() {
		return new CarFragment();
	}

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
							 @Nullable Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.car_fragment, container, false);
		name = view.findViewById(R.id.carName);
		fuel = view.findViewById(R.id.carFuel);

		return view;
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		//Associate the UI Controller and ViewModel
		//ViewModelProviders.of(<Your UI controller>).get(<Your ViewModel>.class)
		//It creates a new ViewModel instance. When this method is called again, which happens whenever
		//onCreate is called, it will return the pre-existing ViewModel associated with the specific
		//Court-Counter MainActivity. This is what preserves the data.
		mViewModel = ViewModelProviders.of(this).get(CarViewModel.class);

		mViewModel.getCar().observe(this, new Observer<Car>() {
			@Override
			public void onChanged(@Nullable Car car) {
				Log.i(TAG, "Car data changed!");
				if(car != null) {
					name.setText(car.getName());
					fuel.setText(car.getFuel());
				}
			}
		});

		//Fake loading data:
		mViewModel.setCar("Volkswagen", "Gasoline");
	}
}
