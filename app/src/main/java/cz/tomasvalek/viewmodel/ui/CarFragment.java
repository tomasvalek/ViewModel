package cz.tomasvalek.viewmodel.ui;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
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
		//If the activity is re-created, it receives the same MyViewModel instance that was created
		// by the first activity. When the owner activity is finished, the framework calls
		// the ViewModel objects's onCleared() method so that it can clean up resources.
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
