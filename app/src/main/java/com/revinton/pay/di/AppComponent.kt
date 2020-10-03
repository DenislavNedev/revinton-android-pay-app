package com.revinton.pay.di

import com.revinton.pay.RevintonPayApplication
import com.revinton.pay.di.modules.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        ViewModelBuilderModule::class,
        ApplicationBindingModule::class,
        ViewModelModule::class,
        NetworkModule::class,
        RepositoryModule::class
    ]
)
interface AppComponent : AndroidInjector<RevintonPayApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: RevintonPayApplication): Builder

        fun build(): AppComponent
    }
}