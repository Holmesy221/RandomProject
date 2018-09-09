package holmes.holmesy.randomproject.Data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "objectives_table")
public class Objectives {


    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "objective")
    private String mObjective;

    @NonNull
    @ColumnInfo(name = "month")
    private String mMonth;


    public  Objectives (@NonNull String objective, String month){
        this.mMonth = month;
        this.mObjective = objective;

    }

    public String getObjective() {
        return mObjective;
    }

    public String getMonth() {
        return mMonth;
    }




}
