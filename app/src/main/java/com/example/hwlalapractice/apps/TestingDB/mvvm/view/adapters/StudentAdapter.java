package com.example.hwlalapractice.apps.TestingDB.mvvm.view.adapters;

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

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MyViewHolder> {
    private ItemChatBinding itemChatBinding;
    private Context context;
    private List<StudentWithAddress> studentWithAddressList;

    public StudentAdapter(Context context) {
        this.context = context;
    }
    public void setStudentList(List<StudentWithAddress> studentWithAddressList)
    {
        this.studentWithAddressList = studentWithAddressList;
    }

    public void notifyChanged()
    {
        notifyDataSetChanged();
    }

    public void clearList()
    {
        studentWithAddressList.clear();
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        itemChatBinding = ItemChatBinding.inflate(LayoutInflater.from(context), parent, false);
        return new MyViewHolder(itemChatBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        int size = studentWithAddressList.get(position).getAddress().size();
        String name = studentWithAddressList.get(position).getStudent().getName();
        String area = studentWithAddressList.get(position).getAddress().get(size-1).getArea();
        String city = studentWithAddressList.get(position).getAddress().get(size-1).getCity();
        String country = studentWithAddressList.get(position).getAddress().get(size-1).getCountry();
        String address = area+ "," +city+ "," +country;

        String student_id = studentWithAddressList.get(position).getStudent().getStudent_id();

        itemChatBinding.nameTv.setText(name);
        itemChatBinding.cnic.setText(student_id);
        itemChatBinding.msgTv.setText(address);
    }

    @Override
    public int getItemCount() {
        return studentWithAddressList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
