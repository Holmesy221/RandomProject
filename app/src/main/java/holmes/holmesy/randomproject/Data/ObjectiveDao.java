package holmes.holmesy.randomproject.Data;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ObjectiveDao {

    @Insert
    void insert(Objectives objectives);

    @Query("DELETE FROM objectives_table")
    void deleteAll();

    @Query("SELECT * from objectives_table ORDER BY month ASC")
    LiveData<List<Objectives>> getAllObjectives();

}
