package com.example.hwlalapractice.apps.TestingDB.mvvm.view.adapters;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Insert;

import com.example.hwlalapractice.apps.TestingDB.mvvm.repository.db.localdb.entity.Student;
import com.example.hwlalapractice.apps.TestingDB.mvvm.repository.db.localdb.entity.relation.onetomany.StudentWithAddress;
import com.example.hwlalapractice.databinding.ItemChatBinding;

import java.util.List;
import java.util.zip.Inflater;

public class StudentAdapter extends BaseAdapter<ItemChatBinding, StudentWithAddress> {

    public StudentAdapter(Context context) {
        super(context);
    }

    @Override
    protected ItemChatBinding initBindingRef(LayoutInflater inflater, ViewGroup parent) {
        return mItemBinding = ItemChatBinding.inflate(inflater, context, false);
    }

    @Override
    protected View initRoot() {
        return mItemBinding.getRoot();
    }

    @Override
    protected void bindItems(int position) {
        int size = mItemList.get(position).getAddress().size();
        String name = mItemList.get(position).getStudent().getName();
        String area = mItemList.get(position).getAddress().get(size-1).getArea();
        String city = mItemList.get(position).getAddress().get(size-1).getCity();
        String country = mItemList.get(position).getAddress().get(size-1).getCountry();
        String address = area+ "," +city+ "," +country;

        String student_id = mItemList.get(position).getStudent().getStudent_id();

        itemChatBinding.nameTv.setText(name);
        itemChatBinding.cnic.setText(student_id);
        itemChatBinding.msgTv.setText(address);
    }

    public void setStudentList(List<StudentWithAddress> list)
    {
        this.mItemList = list;
    }

    public void notifyChanged()
    {
        notifyDataSetChanged();
    }

}
