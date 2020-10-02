import br.com.concrete.desafios.register.model.User;
import br.com.concrete.desafios.register.repository.UserRegisterRepository;
import br.com.concrete.desafios.register.service.UserRegisterService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserRegisterServiceTest {

    @InjectMocks
    private UserRegisterService userRegisterService;

    @Mock
    private UserRegisterRepository userRegisterRepository;


    @Test
    public void shouldReturnUser(){
        when(userRegisterRepository.save(any(User.class))).thenReturn(Mockito.mock(User.class));
        User savedUser = userRegisterService.saveUser(new User("aline", "aline@email.com"));
        Assertions.assertNotNull(savedUser);
    }
}
