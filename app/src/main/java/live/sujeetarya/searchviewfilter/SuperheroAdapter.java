package live.sujeetarya.searchviewfilter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SuperheroAdapter extends RecyclerView.Adapter<SuperheroAdapter.SuperheroVH> implements Filterable {
    private ArrayList<SuperheroModel> superheroList;
    private List<SuperheroModel> superheroAll;

    public SuperheroAdapter(ArrayList<SuperheroModel> superheroList) {
        this.superheroList = superheroList;
        superheroAll = new ArrayList<>();
        superheroAll.addAll(superheroList);
    }

    @NonNull
    @Override
    public SuperheroVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_superhero_list, parent, false);
        SuperheroVH superheroVH = new SuperheroVH(view);
        return superheroVH;
    }

    @Override
    public void onBindViewHolder(@NonNull SuperheroVH holder, int position) {
        holder.super_hero_name.setText(superheroList.get(position).getSuperHeroName());
        holder.character_name.setText(superheroList.get(position).getCharacterName());
        holder.actor_name.setText(superheroList.get(position).getActorName());

    }

    @Override
    public int getItemCount() {
        return superheroList.size();
    }

    @Override
    public Filter getFilter() {
        return SuperNameFilter;
    }

    private Filter SuperNameFilter = new Filter() {
        // run on background thread
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            // this list contains the item that matches the user input
            // & these items(list) changes at runtime as user input character
            List<SuperheroModel> filteredList = new ArrayList<>();
            // if search view has no character or null then all the data item is used
            if (constraint.toString().isEmpty() || constraint == null) {
                filteredList.addAll(superheroAll);
            } else {
                String filter = constraint.toString().toLowerCase().trim();
                for (SuperheroModel dataItem : superheroAll) {
                    if (dataItem.getSuperHeroName().toLowerCase().trim().startsWith(filter)) {
                        filteredList.add(dataItem);
                    }
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;

            return filterResults;
        }

        // run on UI thread
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            superheroList.clear();
            superheroList.addAll((Collection<? extends SuperheroModel>) results.values);
            notifyDataSetChanged();
        }
    };


    public class SuperheroVH extends RecyclerView.ViewHolder {

        TextView character_name;
        TextView actor_name;
        TextView super_hero_name;


        public SuperheroVH(@NonNull View itemView) {
            super(itemView);
            character_name = itemView.findViewById(R.id.character_name);
            actor_name = itemView.findViewById(R.id.actor_name);
            super_hero_name = itemView.findViewById(R.id.super_hero_name);
        }
    }
}
