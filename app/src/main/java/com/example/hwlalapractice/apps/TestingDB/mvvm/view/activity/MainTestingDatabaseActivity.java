package com.example.hwlalapractice.apps.TestingDB.mvvm.view.activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.util.Log;
import android.view.View;

import com.example.hwlalapractice.apps.TestingDB.mvvm.repository.db.localdb.entity.Address;
import com.example.hwlalapractice.apps.TestingDB.mvvm.repository.db.localdb.entity.Student;
import com.example.hwlalapractice.apps.TestingDB.mvvm.repository.db.localdb.entity.relation.onetomany.StudentWithAddress;
import com.example.hwlalapractice.apps.TestingDB.mvvm.view.adapters.StudentAdapter;
import com.example.hwlalapractice.apps.TestingDB.mvvm.viewmodel.StudentViewModelTestingDB;
import com.example.hwlalapractice.databinding.ActivityMainTestingDatabaseBinding;
import com.example.hwlalapractice.mvvm.view.activity.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class MainTestingDatabaseActivity extends BaseActivity<ActivityMainTestingDatabaseBinding> {

    private static final String TAG = "testing_db_main";
    StudentViewModelTestingDB testingDBViewModel;
    StudentAdapter studentAdapter;
    @Override
    protected ActivityMainTestingDatabaseBinding initBindingRef() {
        return ActivityMainTestingDatabaseBinding.inflate(getLayoutInflater());
    }

    @Override
    protected View initRoot() {
        return mBinding.getRoot();
    }

    @Override
    protected void clicks() {

        mBinding.addBtnTestingDb.setOnClickListener(view->{
            String name = mBinding.etNameTestingDb.getText().toString().trim();
            String id = mBinding.etIdTestingDb.getText().toString().trim();
            String address = mBinding.etAddressTestingDb.getText().toString().trim();

            String[] list = address.split(",");
            String area = list[0];
            String city = list[1];
            String country = list[2];

            Log.d(TAG, "clicks: " + name + " " +id + " "+ address);

            long sid = testingDBViewModel.saveStudent(new Student(name, id));
            testingDBViewModel.saveAddresses(new Address(area, city, country, sid));
            testingDBViewModel.fetchStudentWithAddresses();//setting data to live data
            observeLiveData();
        });
    }

    private void observeLiveData() {
        testingDBViewModel.getStudentMutableLiveData().observe(this, new Observer<List<StudentWithAddress>>() {
            @Override
            public void onChanged(List<StudentWithAddress> studentWithAddresses) {
                studentAdapter.setStudentList(studentWithAddresses);
                studentAdapter.notifyChanged();
            }
        });
    }

    @Override
    protected void initRef()
    {
        List<StudentWithAddress> list = new ArrayList<>();
        studentAdapter = new StudentAdapter(this);
        testingDBViewModel = new ViewModelProvider(this).get(StudentViewModelTestingDB.class);
        setRecyclerView(list);
    }

    private void setRecyclerView(List<StudentWithAddress> list)
    {
        studentAdapter.setStudentList(list);
//        mBinding.rvUserInfoTestingDb.setHasFixedSize(true);
        mBinding.rvUserInfoTestingDb.setAdapter(studentAdapter);
    }
}