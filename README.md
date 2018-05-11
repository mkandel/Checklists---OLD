# Overview
Checklists is a web based utility for creating shareable checklists

## Setup
To run this project locally, you must have the JDK installed and Java must be available on your 
system's PATH. Once Java is installed, clone the project via Git with the following command:
```bash
git clone git@nhcljira.echoman.local:the-forest/oak.git
```

> If you haven't set up SSH, use `http://nhcljira.echoman.local:81/the-forest/oak.git` instead of the url above

## Running the build
To run the build via Gradle, `cd` into the repository directory and run the following command:
```bash
./gradlew
```

By default, the `clean` and `build` tasks will be run. See the [Gradle documentation about the Java plugin
for more details about these tasks](https://docs.gradle.org/current/userguide/java_plugin.html).

## Commonly Used Properties

[//]: # Properties can be specified in the launch command to override application settings. Here, we are specifying

[//]: # the location of the server port to run on, overriding the default port of 8082:

[//]: # ```bash

[//]: #  java -jar oak.jar --server.port=9000

[//]: # ```


[//]: # Properties are specified with the `--property.name=value` syntax seen above. These properties are either provided by the underlying framework (Spring) or are custom properties specific to the Oak application.

[//]: # Here are some commonly used properties:


[//]: # | Property                  | Description                                                                          |

[//]: # | ------------------------- | ------------------------------------------------------------------------------------ |

[//]: # | server.port               | Set the port that oak runs on. Defaults to 8080.                                     |

[//]: # | logging.file              | Set the location of the log file to generate. Defaults to `<os-tmp-dir>/spring.log`  |

[//]: # | spring.profiles.active    | Set the active profile(s). Defaults to none, which enables the default profile.      |

[//]: # | oak.graylogHost           | The host of the Graylog distributed logging server. Defaults to localhost.           |

[//]: # | oak.instance              | The name of the running instance, used primarily for logging. Defaults to dev.       |


[//]: # Several properties are pre-defined and grouped via Spring 'profiles'. Profiles are basically just a collection

[//]: # of properties, usually associated with a given environment. Profiles can be mixed and matched, and then further

[//]: # customized with runtime properties above.


[//]: # | Profile | Description                                                                                                 |

[//]: # | ------- | ----------------------------------------------------------------------------------------------------------- |

[//]: # | dev     | For developer use only. When used together with `mssql` configures the service to talk to a MSSQL instance. |

[//]: # | mssql   | Activates basic MSSQL settings. Meant to be combined with other profiles.                                   |

[//]: # | qa      | Activates properties specifically for the QA environment.                                                   |
