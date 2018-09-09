package holmes.holmesy.randomproject;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import holmes.holmesy.randomproject.Data.ObjectiveRepository;
import holmes.holmesy.randomproject.Data.Objectives;

public class ObjectiveViewModel extends AndroidViewModel {

    private ObjectiveRepository mObjectiveRepository;
    private LiveData<List<Objectives>> mObjectives;

    public ObjectiveViewModel(@NonNull Application application) {
        super(application);
        mObjectiveRepository = new ObjectiveRepository(application);
        mObjectives = mObjectiveRepository.getAllObjectives();
    }

    LiveData<List<Objectives>> getAllObjectives(){
        return mObjectives;
    }

    private void insert(Objectives objectives){
        mObjectiveRepository.insert(objectives);
    }
}
