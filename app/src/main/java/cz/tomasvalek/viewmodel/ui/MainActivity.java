package cz.tomasvalek.viewmodel.ui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import cz.tomasvalek.viewmodel.R;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main_activity);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.frameLayoutContainer, CarFragment.newInstance())
					.commitNow();
		}
	}
}
