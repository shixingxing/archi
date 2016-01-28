package uk.ivanc.archimvvm;

import android.app.Application;
import android.content.Context;

import rx.Scheduler;
import rx.schedulers.Schedulers;
import uk.ivanc.archimvvm.model.EzloanService;
import uk.ivanc.archimvvm.model.GithubService;

public class ArchiApplication extends Application {

    private GithubService githubService;
    private EzloanService ezloanService;
    private Scheduler defaultSubscribeScheduler;

    public static ArchiApplication get(Context context) {
        return (ArchiApplication) context.getApplicationContext();
    }

    public GithubService getGithubService() {
        if (githubService == null) {
            githubService = GithubService.Factory.create();
        }
        return githubService;
    }

    //For setting mocks during testing
    public void setGithubService(GithubService githubService) {
        this.githubService = githubService;
    }


    public EzloanService getEzloanService() {
        if (ezloanService == null) {
            ezloanService = EzloanService.Factory.create();
        }
        return ezloanService;
    }

    public void setEzloanService(EzloanService ezloanService) {
        this.ezloanService = ezloanService;
    }

    public Scheduler defaultSubscribeScheduler() {
        if (defaultSubscribeScheduler == null) {
            defaultSubscribeScheduler = Schedulers.io();
        }
        return defaultSubscribeScheduler;
    }

    //User to change scheduler from tests
    public void setDefaultSubscribeScheduler(Scheduler scheduler) {
        this.defaultSubscribeScheduler = scheduler;
    }
}
