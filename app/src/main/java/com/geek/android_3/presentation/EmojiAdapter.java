package com.geek.android_3.presentation;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geek.android_3.R;
import com.geek.android_3.domain.Card;

import java.util.Timer;
import java.util.TimerTask;

public class EmojiAdapter extends RecyclerView.Adapter<EmojiAdapter.ViewHolder> {
    private final EmojiGame emojiGame = new EmojiGame();
    private Animation animation;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        animation = AnimationUtils.loadAnimation(parent.getContext(), R.anim.rotate);
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (emojiGame.getCards().size() > 1) {
            holder.onBind(emojiGame.getCards().get(position));
        } else {
            holder.cardTv.setText(R.string.game_over);
            holder.cardTv.setBackgroundColor(holder.itemView.getResources().getColor(R.color.red));
            holder.cardTv.setTextSize(40);
            holder.cardTv.setAnimation(animation);
        }
    }

    @Override
    public int getItemCount() {
        return emojiGame.getCards().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView cardTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardTv = itemView.findViewById(R.id.item_tv);
        }

        public void onBind(Card<String> card) {

            if (card.isFaceUp()) {
                cardTv.setText(card.getContent());
                cardTv.setBackgroundColor(Color.WHITE);

            } else {
                cardTv.setText("");
                cardTv.setBackgroundColor(itemView.getResources().getColor(R.color.purple_200));
            }

            cardTv.setOnClickListener(v -> {
                emojiGame.cardClick(card);
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        for (int i = 0; i < emojiGame.getCards().size(); i++) {
                            if (emojiGame.getCards().get(i).isMatched()) {
                                emojiGame.getCards().remove(i);
                            }
                        }
                    }
                }, 500);
                notifyDataSetChanged();

            });
        }
    }

}
