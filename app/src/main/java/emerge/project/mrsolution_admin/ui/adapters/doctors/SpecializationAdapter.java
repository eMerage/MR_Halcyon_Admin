package emerge.project.mrsolution_admin.ui.adapters.doctors;


import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import emerge.project.mrsolution_admin.R;
import emerge.project.mrsolution_admin.ui.activity.doctors.DoctorsPresenter;
import emerge.project.mrsolution_admin.ui.activity.doctors.DoctorsPresenterImpli;
import emerge.project.mrsolution_admin.ui.activity.doctors.DoctorsView;
import emerge.project.mrsolution_admin.ui.activity.products.assign_products.AssignProductsPresenter;
import emerge.project.mrsolution_admin.ui.activity.products.assign_products.AssignProductsPresenterImpli;
import emerge.project.mrsolution_admin.ui.activity.products.assign_products.AssignProductsView;
import emerge.project.mrsolution_admin.utils.entittes.Products;
import emerge.project.mrsolution_admin.utils.entittes.Specialization;


/**
 * Created by Himanshu on 4/10/2015.
 */
public class SpecializationAdapter extends RecyclerView.Adapter<SpecializationAdapter.MyViewHolder> {

    Context mContext;
    ArrayList<Specialization> specItems;


    DoctorsPresenter doctorsPresenter;

    public SpecializationAdapter(Context mContext, ArrayList<Specialization> item, DoctorsView doctorsView) {
        this.mContext = mContext;
        this.specItems = item;
        doctorsPresenter = new DoctorsPresenterImpli(doctorsView);
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_specialization, parent, false);

        return new MyViewHolder(itemView);


    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {


        final Specialization specialization = specItems.get(position);

        if (specialization.isSelect()) {
            holder.cardView.setCardBackgroundColor(mContext.getResources().getColor(R.color.colorgold));
        } else {
            holder.cardView.setCardBackgroundColor(mContext.getResources().getColor(R.color.colorWhite));
        }

        holder.textviewSpec.setText(specialization.getName());



        holder.relativeLayoutMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(specialization.isSelect()){
                    specItems.get(position).setSelect(false);
                    doctorsPresenter.assignSpecializationToDocStart(specialization,false);
                }else {
                    specItems.get(position).setSelect(true);
                    doctorsPresenter.assignSpecializationToDocStart(specialization,true);
                }
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return specItems.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.card_view)
        CardView cardView;

        @BindView(R.id.relativeLayout_header_main)
        RelativeLayout relativeLayoutMain;


        @BindView(R.id.textview_spec)
        TextView textviewSpec;



        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }



}
