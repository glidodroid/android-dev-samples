package com.example.developer.android_dev_samples.rxandroid;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.developer.android_dev_samples.R;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import butterknife.BindView;
import butterknife.ButterKnife;
import sample.KotlinActivity;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import timber.log.Timber;

public class RxActivity extends AppCompatActivity {

    private PublishSubject<Integer> subject = PublishSubject.create();
    private final CompositeDisposable disposable = new CompositeDisposable();

    @BindView(R.id.rxtrigger)
    Button rxTrigger;
    @BindView(R.id.text_search)
    EditText editText;
    @BindView(R.id.search_image)
    ImageView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx);
        ButterKnife.bind(this);

        rxTrigger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //doWork();
                //flatMapFilter();
                //subject();
                //disposable();
                startKotlinActivity();

            }
        });
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    searchView.setVisibility(View.GONE);
                }
            }
        });

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Timber.d("on text changed");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    Timber.d("action done clicked");
                }
                return false;
            }
        });
    }

    private void startKotlinActivity() {
        Intent intent = new Intent(this,KotlinActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.clear();
    }

    private void disposable() {
        disposable.add(getSampleObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Timber.d("value %s", s);
                    }
                }));
    }

    private Observable<String> getSampleObservable() {
        return Observable.defer(new Callable<ObservableSource<? extends String>>() {
            @Override
            public ObservableSource<? extends String> call() throws Exception {
                SystemClock.sleep(1000);
                return Observable.just("one", "two", "three", "four");
            }
        });
    }

    private void subject() {
        subject.subscribe(getFirstObserverWithInteger());
        subject.onNext(1);
        subject.onNext(2);
        subject.onNext(3);
        subject.subscribeActual(getSecondObserverWithInteger());
        subject.onNext(4);
        subject.onNext(5);
        subject.onComplete();
    }

    private void doWork() {
        getObservable().onErrorReturn(new Function<Throwable, String>() {
            @Override
            public String apply(Throwable throwable) throws Exception {
                return null;
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getObserver());
    }

    private Observable<String> getObservable() {
        return Observable.just("Cricket", "Football", "Tennis");
    }

    private Observable<Integer> getObservableWithInteger() {
        return Observable.just(1, 2, 3, 4, 5);
    }

    private Observer<Integer> getFirstObserverWithInteger() {
        return new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Timber.d("first onSubscribe %s", d.isDisposed());
            }

            @Override
            public void onNext(Integer integer) {
                Timber.d("first value %s", integer);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                Timber.d("first on complete");
            }
        };
    }

    private Observer<Integer> getSecondObserverWithInteger() {
        return new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Timber.d("second onSubscribe %s", d.isDisposed());
            }

            @Override
            public void onNext(Integer integer) {
                Timber.d("second value %s", integer);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                Timber.d("second on complete");
            }
        };
    }

    private Observer<String> getObserver() {
        return new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                Timber.d("value %s", s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                Timber.d("on complete");
            }
        };
    }

    private void flatMapFilter() {
        getObservableWithListType()
                .flatMap(new Function<List<String>, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(List<String> strings) throws Exception {
                        return Observable.fromIterable(strings);
                    }
                })
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String s) throws Exception {
                        return StringUtils.equalsIgnoreCase(s, "Cricket");
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        Timber.d("value %s", s);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    private Observable<List<String>> getObservableWithListType() {
        return Observable.just(getList());
    }

    private List<String> getList() {
        List<String> list = new ArrayList<>();
        list.add("Cricket");
        list.add("Football");
        list.add("Tennis");
        list.add("Hockey");
        return list;
    }
}
