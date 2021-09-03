package com.example.hwlalapractice.apps.TestingDB.mvvm.viewmodel;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.hwlalapractice.apps.TestingDB.mvvm.repository.db.localdb.Dao.StudentDao;
import com.example.hwlalapractice.apps.TestingDB.mvvm.repository.db.localdb.entity.Address;
import com.example.hwlalapractice.apps.TestingDB.mvvm.repository.db.localdb.entity.Student;
import com.example.hwlalapractice.apps.TestingDB.mvvm.repository.db.localdb.entity.relation.onetomany.StudentWithAddress;
import com.example.hwlalapractice.apps.TestingDB.mvvm.repository.db.localdb.roomdb.Localdb;
import com.example.hwlalapractice.apps.TestingDB.mvvm.view.activity.MainTestingDatabaseActivity;

import java.util.List;

public class StudentViewModelTestingDB extends ViewModel {
    private StudentDao studentDao;
    private MutableLiveData<List<StudentWithAddress>> studentMutableLiveData;

    public StudentViewModelTestingDB() {
        studentMutableLiveData = new MutableLiveData<>();
        studentDao = Localdb.getInstance().getStudentDao();
    }

    public MutableLiveData<List<StudentWithAddress>> getStudentMutableLiveData() {
        return studentMutableLiveData;
    }

    public long saveStudent(Student student)
    {
        Student availableStudent = studentDao.findStudent(student.getName());
        if(availableStudent == null)
        {
            return studentDao.createStudent(student);
        }
        studentDao.updateStudent(student);
        return availableStudent.getSid();
    }

    public void saveAddresses(Address address)
    {
        studentDao.createAddress(address);
    }


    public void fetchStudentWithAddresses()
    {
        List<StudentWithAddress> studentWithAddressList = studentDao.getAllStudentWithAddresses();
        studentMutableLiveData.setValue(studentWithAddressList);
    }
}
