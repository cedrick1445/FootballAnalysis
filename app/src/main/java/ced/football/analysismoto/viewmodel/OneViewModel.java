package ced.football.analysismoto.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import ced.football.analysismoto.R;

public class OneViewModel extends ViewModel {

    private final MutableLiveData<String> home1;
    private final MutableLiveData<String> home2;
    private final MutableLiveData<String> home3;
    private final MutableLiveData<String> home4;
    private final MutableLiveData<Integer> img1;
    private final MutableLiveData<Integer> img2;
    private final MutableLiveData<Integer> img3;
    private final MutableLiveData<Integer> img4;

    public OneViewModel(){

        home1 = new MutableLiveData<>();
        home1.setValue("A team sports played between two groups with eleven players in an football field, where each team or group need to score by kicking the ball into the team's goal.");
        home2 = new MutableLiveData<>();
        home2.setValue("The size of a football/soccer field is about 100m (meters) long and 60m (meters) wide, but in official games, there are some regulations about the minimum and maximum dimensions of a field. In the world or national football, the most official dimensions of the field are those that had been decided by the association of FIFA.");
        home3 = new MutableLiveData<>();
        home3.setValue("The typical grass length on the field is 25-30 mm. The grass is usually cut at every other length from side to side, which brings visible stripes on the grass. By providing a vertical reference, it can help the assistant referee find offside more easily.");
        home4 = new MutableLiveData<>();
        home4.setValue("Except for the goalkeeper in the penalty area, athletes must not touch the ball with their hands or arms during the game. All players in the field mainly use their feet to hit or pass the ball, but may also use any other part of the body (except hands and arms). The team with the most forward goals at the end of the game wins. If the score is at a level at the end of the game, depending on the format of the game, a tie is declared or the game enters overtime or penalty shootout.");

        img1 = new MutableLiveData<>();
        img1.setValue(R.drawable.homeone);
        img2 = new MutableLiveData<>();
        img2.setValue(R.drawable.hometwo);
        img3 = new MutableLiveData<>();
        img3.setValue(R.drawable.homethree);
        img4 = new MutableLiveData<>();
        img4.setValue(R.drawable.homefour);
    }


    public LiveData<String> getHome1(){
        return home1;
    }
    public LiveData<String> getHome2(){
        return home2;
    }
    public LiveData<String> getHome3(){
        return home3;
    }
    public LiveData<String> getHome4(){
        return home4;
    }

    public LiveData<Integer> getImg1(){
        return img1;
    }
    public LiveData<Integer> getImg2(){
        return img2;
    }
    public LiveData<Integer> getImg3(){
        return img3;
    }
    public LiveData<Integer> getImg4(){
        return img4;
    }
}
