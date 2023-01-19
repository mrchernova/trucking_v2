/**
package by.project.trucking_v2.service;

import by.project.trucking_v2.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActiveUserServiceImpl implements ActiveUserService{


    @Autowired
    SessionRegistry sessionRegistry;

//    public List<String> getAllActiveUsers() {
//        List<Object> principals = sessionRegistry.getAllPrincipals();
//        User[] users = (User[]) principals.toArray(new User[0]);
//
//        return Arrays.stream(users)
//                .filter(user -> !sessionRegistry.getAllSessions(user, false)
//                .isEmpty()).map(User::getLogin).collect(Collectors.toList());
//}




//        if (principals != null) {
//            List<SessionInformation> sessions = new ArrayList<>();
//            for (Object principal : principals) {
//                sessions.addAll(sessionRegistry.getAllSessions(principal,     false));
//            }
//            return sessions;
//        }
//        return Collections.emptyList();
//    }


}
*/
