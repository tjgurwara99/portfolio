#include <iostream>

// For exit status macros
#include <cstdlib>

// For pid_t data type
#include <unistd.h>
#include <sys/types.h>

// For system logging - might write my own logger just in case it doesn't work for 
// MacOS (Apple System Log was meant to replace syslog() in MacOS but not much info is available) 
#include <syslog.h>

// For umask
#include <sys/stat.h>

// For files - needs C++17 or above
#include <filesystem>

void do_something() {

// TODO
//  Change the location to wherever your main download folder is
//std::filsystem::current_path(const std::filesystem::path& "/Users/taj/Downloads/");



}


int main() {
    pid_t process_id, session_id;
    
    // fork current process - fork is used to create new child processes, 
    // which run concurrently with the parent process.
    process_id = fork();
    
    if(process_id > 0) {
        exit(EXIT_SUCCESS);
    }
    else if (process_id < 0) {
        exit(EXIT_FAILURE);
    }

    // To create logs with 0777 permission (I think)
    umask(0);

    // Open System logs for the child process
    openlog("Downloads_Folder_Cleanup", LOG_NOWAIT | LOG_PID, LOG_USER);
    syslog(LOG_NOTICE, "Successfully started Downloads_Folder_Cleanup");

    // Generate a session id for the child process
    session_id = setsid();

    // Checks for SID of the child process
    if (session_id < 0) {
        // Failure to be logged
        syslog(LOG_ERR, "Could not generate session ID for child process");
        
        // terminate the child process otherwise it will be orphaned
        exit(EXIT_FAILURE);
    }

    // Change directory 
    if ((chdir("/")) < 0) {
        // Log failure
        syslog(LOG_ERR, "Could not change directory to /");
        
        // terminate child process
        exit(EXIT_FAILURE);
    }

    //  close cin cout cerr streams - not needed in daemons
    close(STDIN_FILENO);
    close(STDOUT_FILENO);
    close(STDERR_FILENO);

    const int INTERVAL = 60;

    while(true) {
        do_something();

        sleep(INTERVAL);
    }

    syslog(LOG_NOTICE, "Terminating Download_Folder_cleanup");
    closelog();

    exit(EXIT_SUCCESS);
}
