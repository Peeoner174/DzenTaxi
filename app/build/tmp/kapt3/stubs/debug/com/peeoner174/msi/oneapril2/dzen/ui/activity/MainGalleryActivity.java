package com.peeoner174.msi.oneapril2.dzen.ui.activity;

import java.lang.System;

/**
 * \u0413\u043b\u0430\u0432\u043d\u043e\u0435 \u043e\u043a\u043d\u043e \u0433\u0430\u043b\u0435\u0440\u0435\u0438
 */
@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0002J\u0012\u0010\u0012\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0010H\u0002J\u0016\u0010\u001d\u001a\u00020\u00102\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u001fH\u0002R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/peeoner174/msi/oneapril2/dzen/ui/activity/MainGalleryActivity;", "Landroid/support/v7/app/AppCompatActivity;", "()V", "data", "Ljava/util/ArrayList;", "Lcom/peeoner174/msi/oneapril2/dzen/data/model/Gallery;", "Lkotlin/collections/ArrayList;", "galleryDataLoaderWeb", "Lcom/peeoner174/msi/oneapril2/dzen/producer/GalleryDataLoaderWeb;", "mAdapter", "Lcom/peeoner174/msi/oneapril2/dzen/ui/adapter/GalleryAdapter;", "mRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "url", "", "initRecyclerView", "", "recyclerView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "setToolbar", "showGallery", "notes", "", "app_debug"})
public final class MainGalleryActivity extends android.support.v7.app.AppCompatActivity {
    private com.peeoner174.msi.oneapril2.dzen.ui.adapter.GalleryAdapter mAdapter;
    private android.support.v7.widget.RecyclerView mRecyclerView;
    private final com.peeoner174.msi.oneapril2.dzen.producer.GalleryDataLoaderWeb galleryDataLoaderWeb = null;
    private java.util.ArrayList<com.peeoner174.msi.oneapril2.dzen.data.model.Gallery> data;
    private java.lang.String url;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initRecyclerView(android.support.v7.widget.RecyclerView recyclerView) {
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
    
    private final void showGallery(java.util.List<com.peeoner174.msi.oneapril2.dzen.data.model.Gallery> notes) {
    }
    
    private final void setToolbar() {
    }
    
    public MainGalleryActivity() {
        super();
    }
}