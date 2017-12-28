package com.example.developer.android_dev_samples.inject;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by developer on 28/12/17.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerChildFragment {
}
