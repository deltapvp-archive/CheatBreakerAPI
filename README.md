
<p align="center">
  <img width="150" height="150" src="https://pbs.twimg.com/profile_images/1374184184349138946/TPO6yGc2_400x400.jpg">
</p>

## CheatBreaker 2017 Bukkit API

The CheatBreaker API will allow you to detect when a player is running CheatBreaker 2017, enable and disable staff modules, set waypoints, and much more.

## Reporting an issue

If you feel there is an issue, you can submit one [here](https://github.com/CheatBreaker2017/CheatBreakerAPI/issues).

## Get the Source

1. Install maven `sudo apt-get install maven`
2. Verify installation `mvn -v`
3. Clone the repository `git clone git@github.com:CheatBreaker2017/CheatBreakerAPI.git`
4. Navigate to the new folder `cd cheatbreakerapi`
5. Import `pom.xml` into your IDE

## Compile a Build

1. Navigate to the repository home directory
2. Run `mvn clean install`
3. Find the compiled jar at `target/CheatBreakerAPI.jar`

## Contributing

You can submit a [pull request](https://github.com/CheatBreaker2017/CheatBreakerAPI/pulls) with your changes.

## Documentation

This CheatBreakerAPI is unique to 2017 CheatBreaker, and ise based from the original, everything from the [official bukkit api](https://github.com/CheatBreaker/CheatBreakerAPI) have carried over, with minor adjustments for 2017 CheatBreaker.

What's new is checking if a player is 2017 CheatBreaker banned, as well as two new commands to check if a player is banned or if they are running 2017 CheatBreaker.

To manually check if a player is running 2017 CheatBreaker, use `/cheatbreaker <target>`.
To manually check if a player is 2017 CheatBreakekr banned, use `/ischeatbreakerbanned <target>`.

**To check if a player is 2017 CheatBreaker Banned, use `CheatBreakerAPI.getInstance().isCheatBreakerBanned(Player player);`.**

**To check if a player is using 2017 CheatBreaker, use `CheatBreakerAPI.getInstance().isRunningCheatBreaker(Player player);`.**

---