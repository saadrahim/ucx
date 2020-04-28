// This file is for internal AMD use.
// If you are interested in running your own Jenkins, please raise a github issue for assistance.

def runCompileCommand(platform, project, jobName)
{
    project.paths.construct_build_prefix()

    def command = """#!/usr/bin/env bash
                set -x
                cd ${project.paths.project_build_prefix}
                ${project.paths.build_command}
            """

    platform.runCommand(this,command)
}

def runTestCommand (platform, project)
{
    def command = """#!/usr/bin/env bash
                set -x
                cd ${project.paths.project_build_prefix}
                ./test/gtest/gtest --gtest_output=xml --gtest_color=yes --gtest_filter=*rocm*
            """

   platform.runCommand(this, command)
   junit "${project.paths.project_build_prefix}/*.xml"
}


def runPackageCommand(platform, project, jobName)
{
    def command = """
            """

	platform.runCommand(this,command)
}

return this
