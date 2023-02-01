package com.example.learningtracker;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class myRecyclerViewAdapter extends RecyclerView.Adapter<myRecyclerViewAdapter.MyVH> {


    List<LearningModel> studentList;
//variable to hold recyclerview interface
    private final RecyclerViewInterface recyclerViewInterface;

    public myRecyclerViewAdapter(List<LearningModel> studentList, RecyclerViewInterface recyclerViewInterface1) {
        this.studentList = studentList;
        this.recyclerViewInterface=recyclerViewInterface1;
    }

    @NonNull
    @Override
    public MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.singlerow, parent, false);
        return new MyVH(itemView,recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVH holder, int position) {

        holder.data=studentList.get(position);
        holder.textViewFriendName.setText(holder.data.getStudentName());
        holder.textViewCity.setText(String.valueOf(holder.data.getStudentDept()));
     //   holder.imageViewFriend.setImageResource(holder.data.getImageID());
       // holder.textViewCity.setText(holder.data.getCity());

    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public static class MyVH extends RecyclerView.ViewHolder {
        ImageView imageViewFriend;
        TextView textViewFriendName;
        TextView textViewdateFriend;
        TextView textViewCity;
        LearningModel data;
        public MyVH(@NonNull View itemView,RecyclerViewInterface recyclerViewInterface) {
            //in oncreate pass recyler view
            super(itemView);
            imageViewFriend = itemView.findViewById(R.id.imageViewFriendPicture);
            textViewFriendName = itemView.findViewById(R.id.textViewFriendName);
            textViewCity = itemView.findViewById(R.id.textViewCity);

            //attach onclicklistener to item view
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recyclerViewInterface !=null)
                    {
                        //now grap the positiion
                        int pos=getAdapterPosition();
                        if(pos!=RecyclerView.NO_POSITION)
                        {
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });

        }
    }

}

