package inwiter.materialdesign;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by bhanu on 13/10/15.
 */
public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    List<dataSet> data = Collections.emptyList();

    public recyclerAdapter(Context context, List<dataSet> dataSetList){
        inflater = LayoutInflater.from(context);
        this.data = dataSetList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.customrow_dashboard, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        dataSet current = data.get(position);
        Log.e("App", "recyclearAdapter.java: "+current.title);
        Log.e("App", "recyclearAdapter.java: "+current.iconId);
        holder.title.setText(current.title);
        holder.icon.setImageResource(current.iconId);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView icon;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.list_text);
            icon = (ImageView) itemView.findViewById(R.id.list_icon);
        }
    }
}
