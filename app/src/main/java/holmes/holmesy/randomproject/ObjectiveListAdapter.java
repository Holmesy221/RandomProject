package holmes.holmesy.randomproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import holmes.holmesy.randomproject.Data.Objectives;

public class ObjectiveListAdapter extends RecyclerView.Adapter<ObjectiveListAdapter.ObjectiveViewHolder>{


    class ObjectiveViewHolder extends RecyclerView.ViewHolder{
      private final TextView mDateTv;
      private final TextView mObjTv;

        public ObjectiveViewHolder(View itemView) {
            super(itemView);
            mDateTv = itemView.findViewById(R.id.textView);
            mObjTv = itemView.findViewById(R.id.textView2);
        }
    }

    private final LayoutInflater mInflater;
    private List<Objectives> mObjectives;

    ObjectiveListAdapter (Context context){
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public ObjectiveViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new ObjectiveViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull ObjectiveListAdapter.ObjectiveViewHolder holder, int position) {

        if (mObjectives != null){
            Objectives current = mObjectives.get(position);
            holder.mDateTv.setText(current.getMonth());
            holder.mObjTv.setText(current.getObjective());
        } else {
            holder.mDateTv.setText("No month");
            holder.mObjTv.setText("No Objective");
        }
    }


    public void setObjectives(List<Objectives> objectives){
        mObjectives = objectives;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mObjectives != null) {
            return mObjectives.size();
        } else {
            return 0;
        }
    }
}
