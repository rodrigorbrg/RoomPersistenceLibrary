package br.com.next.movile.androidroom.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import br.com.next.movile.androidroom.model.Word;

@Dao
public interface WordDao {
    /*
        Nossa chave primária é a palavra
        Default SQL Behavior para conflito é ABORT para que não
        seja possível inserir dois itens com a mesma primary key
        no banco
        Se a tabela tiver mais que uma coluna é possível usar:
        @Insert(onConflict = OnConflictStrategy.REPLACE)
    */

    @Insert
    void insert(Word word);

    @Query("DELETE FROM word_table")
    void deleteAll();

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    LiveData<List<Word>> getAllWords();

}
