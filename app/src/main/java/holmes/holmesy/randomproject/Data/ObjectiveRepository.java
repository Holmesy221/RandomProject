package holmes.holmesy.randomproject.Data;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class ObjectiveRepository {

    private ObjectiveDao mObjectiveDao;
    private LiveData<List<Objectives>> mObjectives;

    public ObjectiveRepository(Application application){
        ObjectiveRoomDatabase db = ObjectiveRoomDatabase.getDatabase(application);
        mObjectiveDao = db.objectiveDao();
        mObjectives = mObjectiveDao.getAllObjectives();
    }

   public  LiveData<List<Objectives>> getAllObjectives(){
        return mObjectives;
    }

    public void insert (Objectives objectives){
        new insertAsyncTask(mObjectiveDao).execute(objectives);
    }


    private static class insertAsyncTask extends AsyncTask<Objectives, Void,Void>{
        private ObjectiveDao mAsyncTaskDao;
        insertAsyncTask(ObjectiveDao dao){
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Objectives... params){
            mAsyncTaskDao.insert(params[0]);
            return null;
        }


    }



}