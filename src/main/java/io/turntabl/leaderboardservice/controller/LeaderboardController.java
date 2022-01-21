package io.turntabl.leaderboardservice.controller;

import io.turntabl.leaderboardservice.client.response.UserDto;
import io.turntabl.leaderboardservice.controller.response.ProfileDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/leaderboard")
@CrossOrigin("http://localhost:4200")
public class LeaderboardController {

    private final LeaderboardFacade leaderboardFacade;

    @GetMapping
    public List<ProfileDto> getLeaderboard() {
        return leaderboardFacade.getLeaderboard();
    }

    @GetMapping("/{language}")
    public List<ProfileDto> getProfileByLanguage(@PathVariable("language") String language) {
        return leaderboardFacade.getProfileByLanguage(language);
    }

    @PostMapping("/add/{username}")
    public ProfileDto addUserToLeaderboard(@RequestParam String username) {
        return leaderboardFacade.addProfileToLeaderboard(username);
    }
}
