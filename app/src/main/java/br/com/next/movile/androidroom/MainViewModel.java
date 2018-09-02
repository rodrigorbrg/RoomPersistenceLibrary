package br.com.next.movile.androidroom;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

import br.com.next.movile.androidroom.model.Word;
import br.com.next.movile.androidroom.repository.WordRepository;

public class MainViewModel extends AndroidViewModel {

    WordRepository repository;
    private LiveData<List<Word>> allWords;

    public MainViewModel(Application application) {
        super(application);
        repository = new WordRepository(application);
        allWords = repository.getAllWords();
    }

    public LiveData<List<Word>> getAllWords() {
        return allWords;
    }

    public void insert(Word word) {
        repository.insert(word);
    }
}
