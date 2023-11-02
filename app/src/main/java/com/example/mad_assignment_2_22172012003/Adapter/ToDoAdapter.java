package com.example.mad_assignment_2_22172012003.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mad_assignment_2_22172012003.MainActivity;
import com.example.mad_assignment_2_22172012003.Model.ToDoModel;
import com.example.mad_assignment_2_22172012003.R;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ViewHolder> {

    private List<ToDoModel> todoList;
    private MainActivity activity;

    public ToDoAdapter(MainActivity activity){

        this.activity = activity;
    }
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_layout, parent, false);
        return new ViewHolder(itemView);
    }

    public void onBindViewHolder(ViewHolder holder, int position){
        ToDoModel item =todoList.get(position);
        holder.task.setText(item.getTask());
        holder.task.setChecked(toBoolean(item.getStatus()));
    }

    public int getItemCount(){

        return todoList.size();
    }

    private boolean toBoolean(int n) {
        return n!=0;
    }
    public void setTask(List<ToDoModel> todoList){
        this.todoList = todoList;
        notifyDataSetChanged();
    }

    public void setTasks(List<ToDoModel> taskList) {
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        CheckBox task;

        ViewHolder(View view){
            super(view);
            task = view.findViewById(R.id.todoCheckBox);
        }

    }

}


