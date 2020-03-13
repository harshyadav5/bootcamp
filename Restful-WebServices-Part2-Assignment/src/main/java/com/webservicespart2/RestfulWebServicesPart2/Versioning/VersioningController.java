package com.webservicespart2.RestfulWebServicesPart2.Versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {

    //URI VERSIONING
    @GetMapping("oldversion")
    public OldVersion oldVersion(){
        return new OldVersion(new User(4040,"Harsh Yadav"));
    }
    @GetMapping("latestversion")
    public LatestVersion latestVersion(){
        return new LatestVersion(new User(4040,"Harsh Yadav",90840,"Greater Noida"));
    }

    //Request Versioning
    @GetMapping(value = "oldversion/param",params = "Version=1")
    public OldVersion oldRequestVersion(){
        return new OldVersion(new User(4040,"Harsh Yadav"));
    }
    @GetMapping(value = "latestversion/param",params = "Version=2")
    public LatestVersion latestRequestVersion(){
        return new LatestVersion(new User(4040,"Harsh Yadav",90840,"Greater Noida"));
    }

    //Custom Header Versioning
    @GetMapping(value = "oldversion/header",headers = "X-API-VERSION=1")
    public OldVersion oldHeaderVersion(){
        return new OldVersion(new User(4040,"Harsh Yadav"));
    }
    @GetMapping(value = "latestversion/header",headers = "X-API-VERSION=2")
    public LatestVersion latestHeaderVersion(){
        return new LatestVersion(new User(4040,"Harsh Yadav",90840,"Greater Noida"));
    }

    //MimeType Versioning
    @GetMapping(value = "oldversion/produces",produces = "application/und.company.app-VI+JSON")
    public OldVersion oldMediaTypeVersion(){
        return new OldVersion(new User(4040,"Harsh Yadav"));
    }
    @GetMapping(value = "latestversion/produces",produces = "application/und.company.app-VI+JSON")
    public LatestVersion latestMediaTypeVersion(){
        return new LatestVersion(new User(4040,"Harsh Yadav",90840,"Greater Noida"));
    }
}
