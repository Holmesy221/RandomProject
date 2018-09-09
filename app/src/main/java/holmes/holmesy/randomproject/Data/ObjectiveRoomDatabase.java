package holmes.holmesy.randomproject.Data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;


@Database(entities = {Objectives.class}, version = 1)
public abstract class ObjectiveRoomDatabase extends RoomDatabase {

    public abstract ObjectiveDao objectiveDao();

    private static ObjectiveRoomDatabase INSTANCE;

    public static ObjectiveRoomDatabase getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (ObjectiveRoomDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    ObjectiveRoomDatabase.class, "objective_database")
                    .build();
                }
            }
        }
        return INSTANCE;
    }



}
