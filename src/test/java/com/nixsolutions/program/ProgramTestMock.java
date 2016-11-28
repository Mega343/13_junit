package com.nixsolutions.program;

import com.nixsolutions.robot.Robot;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.File;
import java.io.Writer;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ProgramTestMock {

    @Mock
    private Robot robot;
    @InjectMocks
    private Program program;
    @Captor
    private ArgumentCaptor<Writer> captor;

    @Test
    public void shouldGenerateRobotRoute() throws Exception {
        //given
        given(program.readRoute(null)).willReturn("lffrflfrrfff");

        //when
        program.robotMove(null, any(File.class));

        //then
        verify(program).writeRoute(captor.capture(), any(File.class));

    }

}
