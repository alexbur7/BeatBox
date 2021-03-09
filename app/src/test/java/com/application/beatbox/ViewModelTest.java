package com.application.beatbox;

import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ViewModelTest {

    private BeatBox mBeatBox;
    private Sound mSound;
    private ViewModel mSubject;

    @Before
    public void setUp() throws Exception {
        mBeatBox=mock(BeatBox.class);
        mSound=new Sound("filepath");
        mSubject=new ViewModel(mBeatBox);
        mSubject.setSound(mSound);
    }

    @Test
    public void exposesSoundNameAsTitle(){
        MatcherAssert.assertThat(mSubject.getTitle(), is(mSound.getName()));
    }

    @Test
    public void callsBeatBoxButtonClicked(){
        mSubject.onButtonClicked();
        verify(mBeatBox).playSound(mSound);
    }
}