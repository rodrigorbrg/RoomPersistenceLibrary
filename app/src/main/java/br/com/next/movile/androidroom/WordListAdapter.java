package br.com.next.movile.androidroom;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.next.movile.androidroom.model.Word;

public class WordListAdapter extends
        RecyclerView.Adapter<WordListAdapter.WordViewHolder> {


    private final LayoutInflater mInflater;
    private List<Word> mWords; // Cópia de words armazenada nocache

    WordListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView =
                mInflater.inflate(R.layout.recycleview_item, parent, false);
        return new WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        if (mWords != null) {
            Word current = mWords.get(position);
            holder.wordItemView.setBackgroundColor(
                    position%2 ==0 ?
                    holder.wordItemView.getResources().getColor(R.color.branco) :
                    holder.wordItemView.getResources().getColor(R.color.darker_gray) );
            holder.wordItemView.setText(current.getWord());
        }
    }

    void setWords(List<Word> words) {
        mWords = words;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return  (mWords != null) ? mWords.size() : 0;
    }


    class WordViewHolder extends RecyclerView.ViewHolder {
        private final TextView wordItemView;


        WordViewHolder(@NonNull View itemView) {
            super(itemView);
            wordItemView =
                    itemView.findViewById(R.id.textView);

        }
    }
}
