package br.com.concrete.desafios.service;

import br.com.concrete.desafios.repository.RouteManagerRepository;
import java.util.List;

public class RouteManagerService {

    private final RouteManagerRepository routeManagerRepository;

    public RouteManagerService(RouteManagerRepository routeManagerRepository) {
        this.routeManagerRepository = routeManagerRepository;
    }

    public Boolean checkRoutes(final String routeParam) {
        final List<String> routes = routeManagerRepository.findAllRoutes();

        for (String route : routes) {

            if (!route.contains("user_id"))  return routes.contains(routeParam);

            if (route.split("/")[2].contains("user_id")){

                String[] routeSplit = routeParam.split("/");
                if ( routeSplit.length >= 3 && route.contains(routeSplit[1])) {
                    if (routeParam.charAt(0) == '/') {
                        return "/".concat(route.split("/")[1]).concat("/".concat(routeSplit[2])).equals(routeParam);
                    }
                }
            }
        }
        return false;
    }
}
