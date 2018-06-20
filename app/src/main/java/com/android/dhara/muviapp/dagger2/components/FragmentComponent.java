package com.android.dhara.muviapp.dagger2.components;

import com.android.dhara.muviapp.home.category.view.CategoryFragment;
import com.android.dhara.muviapp.dagger2.injection.PerFragment;
import com.android.dhara.muviapp.dagger2.modules.FragmentModule;
import com.android.dhara.muviapp.home.collections.view.CollectionsFragment;

import dagger.Component;

@PerFragment
@Component(modules = {FragmentModule.class}, dependencies = {AppComponent.class, MuViAppComponent.class})
public interface FragmentComponent {
    void inject(CategoryFragment categoryFragment);

    void inject(CollectionsFragment collectionsFragment);
}
