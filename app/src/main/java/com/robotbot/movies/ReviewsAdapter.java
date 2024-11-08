package com.robotbot.movies;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ReviewsAdapter extends RecyclerView.Adapter<ReviewsAdapter.ReviewViewHolder> {

    private static final String NEGATIVE_REVIEW = "Негативный";
    private static final String NEUTRAL_REVIEW = "Нейтральный";
    private static final String POSITIVE_REVIEW = "Позитивный";

    private List<Review> reviews = new ArrayList<>();

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.review_item,
                parent,
                false
        );
        return new ReviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {
        Review review = reviews.get(position);
        int colorResId;
        switch (review.getType()) {
            case NEGATIVE_REVIEW:
                colorResId = android.R.color.holo_red_light;
                break;
            case NEUTRAL_REVIEW:
                colorResId = android.R.color.holo_orange_light;
                break;
            case POSITIVE_REVIEW:
                colorResId = android.R.color.holo_green_light;
                break;
            default:
                throw new RuntimeException("Неправильная обработка ответа от API");
        }
        int color = ContextCompat.getColor(holder.itemView.getContext(), colorResId);
        holder.cardViewReview.setCardBackgroundColor(color);
        holder.textViewAuthor.setText(review.getAuthor());
        holder.textViewReview.setText(review.getText());
    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    static class ReviewViewHolder extends RecyclerView.ViewHolder {

        private CardView cardViewReview;
        private TextView textViewAuthor;
        private TextView textViewReview;

        public ReviewViewHolder(@NonNull View itemView) {
            super(itemView);
            cardViewReview = itemView.findViewById(R.id.cardViewReview);
            textViewAuthor = itemView.findViewById(R.id.textViewAuthor);
            textViewReview = itemView.findViewById(R.id.textViewReview);
        }
    }

}
