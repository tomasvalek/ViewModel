package cz.tomasvalek.viewmodel.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import cz.tomasvalek.viewmodel.model.Car;

/** ViewModels should not, though, hold a reference to Activities, Fragments, or Contexts.
 * Furthermore, ViewModels should not contain elements that contain references to UI controllers,
 * such as Views, since this will create an indirect reference to a Context.
 * The reason you shouldn’t store these objects is that ViewModels outlive your specific UI
 * controller instances — if you rotate an Activity three times, you have just created three different
 * Activity instances, but you only have one ViewModel.
 * Sometimes you might need an Application context Application context in a ViewModel is okay because
 * an Application context is tied to the Application lifecycle. This is different from an Activity
 * context, which is tied to the Activity lifecycle.
 * */
public class CarViewModel extends ViewModel {

	private MutableLiveData<Car> carLiveData = new MutableLiveData<>(); //Mutable==changeable

	//Not use reference to context, activity, fragments, etc. Only Application context if you need

	private Car car;

	/**Construct
	 * */
	public CarViewModel(){
	}

	public void setCar(String name, String fuel){
		car = new Car(name, fuel);
		carLiveData.setValue(car);
	}

	public MutableLiveData<Car> getCar(){
		return carLiveData;
	}

}
