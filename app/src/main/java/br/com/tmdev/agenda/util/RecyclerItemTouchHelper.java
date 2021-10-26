package br.com.tmdev.agenda.util;

import android.graphics.Canvas;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import br.com.tmdev.agenda.ui.adapter.AgendaAdapter;

public class RecyclerItemTouchHelper extends ItemTouchHelper.SimpleCallback{

    private RecyclerItemTouchHelperListener mLister;

    public RecyclerItemTouchHelper(int dragDirs, int swipeDirs, RecyclerItemTouchHelperListener listener) {
        super(dragDirs, swipeDirs);

        this.mLister = listener;
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return true;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        if (mLister != null) {
            mLister.onSwiped(viewHolder, direction, viewHolder.getAdapterPosition());
        }
    }

    @Override
    public int convertToAbsoluteDirection(int flags, int layoutDirection) {
        return super.convertToAbsoluteDirection(flags, layoutDirection);
    }

    @Override
    public void clearView(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
       View viewForeground = ((AgendaAdapter.ViewHolder)viewHolder).getMViewForeground();
       getDefaultUIUtil().clearView(viewForeground);
    }

    @Override
    public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int actionState) {
        if (viewHolder != null) {
            View viewForeground = ((AgendaAdapter.ViewHolder)viewHolder).getMViewForeground();
            getDefaultUIUtil().onSelected(viewForeground);
        }
    }

    @Override
    public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        View viewForeground = ((AgendaAdapter.ViewHolder)viewHolder).getMViewForeground();
        getDefaultUIUtil().onDraw(c, recyclerView, viewForeground, dX, dY, actionState, isCurrentlyActive);
    }

    @Override
    public void onChildDrawOver(@NonNull Canvas c, @NonNull RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        View viewForeground = ((AgendaAdapter.ViewHolder)viewHolder).getMViewForeground();
        getDefaultUIUtil().onDrawOver(c, recyclerView, viewForeground, dX, dY, actionState, isCurrentlyActive);
    }

}
