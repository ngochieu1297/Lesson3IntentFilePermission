package com.example.admin.lesson3intentfilepermission;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder> {
    private List<Photo> mPhotos;
    public static final int INDEX_INIT = 1;
    private final int height = 800;

    public PhotoAdapter(List<Photo> mPhotos) {
        this.mPhotos = mPhotos;
    }

    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_photo, parent, false);
        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PhotoViewHolder holder, int position) {
        holder.loadImage(mPhotos.get(position));
    }

    @Override
    public int getItemCount() {
        return mPhotos.size();
    }

    public void addPhoto(Photo photo) {
        mPhotos.add(photo);
        notifyItemInserted(mPhotos.size() - INDEX_INIT);
    }

    public class PhotoViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView;

        public PhotoViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_view_photo);
        }

        private void loadImage(Photo photo) {
            Glide.with(itemView.getContext())
                    .load(photo.getUrl())
                    .apply(new RequestOptions().override(MainActivity.width / 2, height))
                    .into(mImageView);
        }
    }
}
