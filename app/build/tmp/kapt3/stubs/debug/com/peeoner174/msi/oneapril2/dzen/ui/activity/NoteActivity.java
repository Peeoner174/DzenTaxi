package com.peeoner174.msi.oneapril2.dzen.ui.activity;

import java.lang.System;

/**
 * \u0417\u0430\u043f\u0438\u0441\u043a\u0438 \u043f\u043e\u0435\u0437\u0434\u043a\u0438 
 */
@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\fH\u0002J\u0016\u0010\u001a\u001a\u00020\f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/peeoner174/msi/oneapril2/dzen/ui/activity/NoteActivity;", "Landroid/support/v7/app/AppCompatActivity;", "()V", "adapter", "Lcom/peeoner174/msi/oneapril2/dzen/ui/adapter/RecViewNoteAdapter;", "dataLoader", "Lcom/peeoner174/msi/oneapril2/dzen/producer/NoteDataLoaderWeb;", "layoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "url", "", "initRecyclerView", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "setToolbar", "showUsers", "notes", "", "Lcom/peeoner174/msi/oneapril2/dzen/data/model/Note;", "app_debug"})
public final class NoteActivity extends android.support.v7.app.AppCompatActivity {
    private com.peeoner174.msi.oneapril2.dzen.ui.adapter.RecViewNoteAdapter adapter;
    private final android.support.v7.widget.RecyclerView.LayoutManager layoutManager = null;
    private final com.peeoner174.msi.oneapril2.dzen.producer.NoteDataLoaderWeb dataLoader = null;
    private java.lang.String url;
    private java.util.HashMap _$_findViewCache;
    
    /**
     * * \u0421\u0442\u0430\u0440\u0442\u043e\u0432\u044b\u0439 \u043c\u0435\u0434\u043e\u0442 Activity
     *     * \u0441 \u043d\u0435\u0433\u043e \u043d\u0430\u0447\u0438\u043d\u0430\u0435\u0442\u0441\u044f \u0436\u0438\u0437\u043d\u0435\u043d\u043d\u044b\u0439 \u0446\u0438\u043a\u043b \u043a\u043e\u043c\u043f\u043e\u0435\u043d\u0435\u043d\u0442\u0430
     *     * https://developer.android.com/guide/components/activities/activity-lifecycle.html
     */
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.NotNull()
    android.view.Menu menu) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    private final void initRecyclerView(android.support.v7.widget.RecyclerView recyclerView) {
    }
    
    private final void showUsers(java.util.List<com.peeoner174.msi.oneapril2.dzen.data.model.Note> notes) {
    }
    
    private final void setToolbar() {
    }
    
    public NoteActivity() {
        super();
    }
}