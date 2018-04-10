package com.peeoner174.msi.oneapril2;

import java.lang.System;

/**
 * * \u041a\u043b\u0430\u0441\u0441 Application - \u044d\u0442\u043e \u0431\u0430\u0437\u043e\u0432\u044b\u0439 \u043a\u043b\u0430\u0441\u0441 \u043f\u0440\u0438\u043b\u043e\u0436\u0435\u043d\u0438\u044f android. \u0421\u043e\u0437\u0434\u0430\u0435\u0442\u0441\u044f \u0440\u0430\u043d\u044c\u0448\u0435 \u043b\u044e\u0431\u043e\u0433\u043e \u0434\u0440\u0443\u0433\u043e\u0433\u043e \u043a\u043b\u0430\u0441\u0441\u0430
 * * \u043f\u0440\u0438\u043b\u043e\u0436\u0435\u043d\u0438\u044f. Singleton
 * * 
 */
@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/peeoner174/msi/oneapril2/App;", "Landroid/app/Application;", "()V", "database", "Lcom/peeoner174/msi/oneapril2/dzen/data/db/AppDatabase;", "getDatabase", "()Lcom/peeoner174/msi/oneapril2/dzen/data/db/AppDatabase;", "setDatabase", "(Lcom/peeoner174/msi/oneapril2/dzen/data/db/AppDatabase;)V", "onCreate", "", "app_debug"})
public final class App extends android.app.Application {
    @org.jetbrains.annotations.NotNull()
    public com.peeoner174.msi.oneapril2.dzen.data.db.AppDatabase database;
    
    @org.jetbrains.annotations.NotNull()
    public final com.peeoner174.msi.oneapril2.dzen.data.db.AppDatabase getDatabase() {
        return null;
    }
    
    public final void setDatabase(@org.jetbrains.annotations.NotNull()
    com.peeoner174.msi.oneapril2.dzen.data.db.AppDatabase p0) {
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    public App() {
        super();
    }
}