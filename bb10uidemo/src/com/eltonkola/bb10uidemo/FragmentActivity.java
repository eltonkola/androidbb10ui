package com.eltonkola.bb10uidemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Toast;

import com.eltonkola.bb10ui.app.BB10FragmentActivity;

public class FragmentActivity extends BB10FragmentActivity{
	
	private MainFragment fragment;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment);
		
		 //fragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.main_fragment);
		
	}
	
	public void onButtonClicked(){
        // handle button clicked
    }
	
	
	public static class MainFragment extends Fragment {


        
        @Override
        public void onAttach(Activity activity) {               
                super.onAttach(activity);               
        }
        
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
                return inflater.inflate(R.layout.fragment_test1, container, false);
        }
        
        @Override
        public void onViewCreated(View view, Bundle savedInstanceState) {
                super.onViewCreated(view, savedInstanceState);
                                
                view.findViewById(R.id.button).setOnClickListener(new OnClickListener() {                       
                        @Override
                        public void onClick(View v) {
                               Toast.makeText(getActivity(), "Hello", Toast.LENGTH_SHORT).show();
                        }
                });
        }
	}
	
	
}
