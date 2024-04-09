package com.example.commidternmaithieutin;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

    public class MyViewModel extends ViewModel {
        private MutableLiveData<Integer> number;

        public LiveData<Integer> getNumber(){
            if(number == null){
                number = new MutableLiveData<>();
                number.setValue(0);
            }

            return number;
        }


    }

