package apprecycler.simbirsoft.com.androidrecyclerview;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void onClick(int position, String value);
    }

    private List<Data> data;

    private final OnItemClickListener onItemClickListener;

    public ViewAdapter(List<Data> data, OnItemClickListener onItemClickListener) {
        this.data = data;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Data dataStruct = data.get(position);
        final ImageView valImage = dataStruct.image;
        final String valText = dataStruct.text;

        holder.setData(dataStruct);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onClick(position, dataStruct.text);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageCard);
            textView = (TextView) itemView.findViewById(R.id.textViewBase);
        }

        public void setData(Data data) {
            // Here I wanted to get image from the list
            /* imageView.setImageResource(data.image. ? ); */

            // This variant leads to the identical images
            /* imageView.setImageResource(R.drawable.img0); */

            // Not automatic because R.drawable.imageName should be full without concatinations
            switch (data.index) {
                case (0): {
                    imageView.setImageURI(Uri.parse(data.resStr + R.drawable.img0));
                    break;
                }
                case (1): {
                    imageView.setImageURI(Uri.parse(data.resStr + R.drawable.img1));
                    break;
                }
                case (2): {
                    imageView.setImageURI(Uri.parse(data.resStr + R.drawable.img2));
                    break;
                }
                case (3): {
                    imageView.setImageURI(Uri.parse(data.resStr + R.drawable.img3));
                    break;
                }
                case (4): {
                    imageView.setImageURI(Uri.parse(data.resStr + R.drawable.img4));
                    break;
                }
                case (5): {
                    imageView.setImageURI(Uri.parse(data.resStr + R.drawable.img5));
                    break;
                }
                case (6): {
                    imageView.setImageURI(Uri.parse(data.resStr + R.drawable.img6));
                    break;
                }
            }

            textView.setText(data.text);
        }

    }
}
