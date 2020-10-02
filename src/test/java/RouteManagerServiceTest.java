import br.com.concrete.desafios.repository.RouteManagerRepository;
import br.com.concrete.desafios.service.RouteManagerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RouteManagerServiceTest {

    @InjectMocks
    private RouteManagerService routeManagerService;
    @Mock
    private RouteManagerRepository routeManagerRepository;

    @Test
    public void shouldReturnsTrueWhenExistsUsersRouteWithParam () {
        when(routeManagerRepository.findAllRoutes()).thenReturn(asList(("/users/{user_id}"), ("/comments/{user_id}")));
        Boolean exists = routeManagerService.checkRoutes("/users/1");
        assertTrue(exists);
    }

    @Test
    public void shouldReturnsTrueWhenExistsCommentsRouteWithParam () {
        when(routeManagerRepository.findAllRoutes()).thenReturn(asList(("/users/{user_id}"), ("/comments/{user_id}")));
        Boolean exists = routeManagerService.checkRoutes("/comments/1");
        assertTrue(exists);
    }

    @Test
    public void shouldReturnsFalseWhenDoesNotExistsUsersRouteWithoutParam () {
        when(routeManagerRepository.findAllRoutes()).thenReturn(asList(("/users/{user_id}"), ("/comments/{user_id}")));
        Boolean exists = routeManagerService.checkRoutes("/users");
        assertFalse(exists);
    }

    @Test
    public void shouldReturnsFalseWhenDoesNotExistsCommentsRouteWithoutParam () {
        when(routeManagerRepository.findAllRoutes()).thenReturn(asList(("/users/{user_id}"), ("/comments/{user_id}")));
        Boolean exists = routeManagerService.checkRoutes("/comments");
        assertFalse(exists);
    }

    @Test
    public void shouldReturnsFalseWhenRouteDoesntMatchWithParam () {
        when(routeManagerRepository.findAllRoutes()).thenReturn(asList(("/users/{user_id}"), ("/comments/{user_id}")));
        Boolean exists = routeManagerService.checkRoutes("/lala/1");
        assertFalse(exists);
    }

    @Test
    public void shouldReturnsFalseWhenRouteDoesntMatchWithoutParam () {
        when(routeManagerRepository.findAllRoutes()).thenReturn(asList(("/users/{user_id}"), ("/comments/{user_id}")));
        Boolean exists = routeManagerService.checkRoutes("/lala");
        assertFalse(exists);
    }

    @Test
    public void shouldReturnsFalseWhenNotExistsSimpleRoute () {
        when(routeManagerRepository.findAllRoutes()).thenReturn(asList(("/users"), "/posts"));
        Boolean exists = routeManagerService.checkRoutes("/usuario");
        assertFalse(exists);
    }

    @Test
    public void shouldReturnsTrueWhenExistsSimpleRoute () {
        when(routeManagerRepository.findAllRoutes()).thenReturn(asList(("/users"), "/posts"));
        Boolean exists = routeManagerService.checkRoutes("/posts");
        assertTrue(exists);
    }

    @Test
    public void shouldReturnsFalseWhenNotExistsRouteWithParam () {
        when(routeManagerRepository.findAllRoutes()).thenReturn(asList(("/users"), "/posts"));
        Boolean exists = routeManagerService.checkRoutes("/users/2");
        assertFalse(exists);
    }

}
