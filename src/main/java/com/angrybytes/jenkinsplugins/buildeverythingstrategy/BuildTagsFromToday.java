package com.angrybytes.jenkinsplugins.buildeverythingstrategy;

import hudson.Extension;

import java.util.concurrent.TimeUnit;

import org.kohsuke.stapler.DataBoundConstructor;
import jenkins.branch.BranchBuildStrategy;
import jenkins.branch.BranchBuildStrategyDescriptor;
import jenkins.scm.api.SCMSource;
import jenkins.scm.api.SCMHead;
import jenkins.scm.api.mixin.ChangeRequestSCMHead;
import jenkins.scm.api.mixin.TagSCMHead;

public class BuildTagsFromToday extends BranchBuildStrategy {

    @DataBoundConstructor
    public BuildTagsFromToday() {
    }

    @Override
    public boolean isAutomaticBuild(SCMSource source, SCMHead head) {
    	return head instanceof TagSCMHead && ((TagSCMHead)head).getTimestamp() > System.currentTimeMillis()-TimeUnit.DAYS.toMillis(1);
    }

    @Extension
    public static class DescriptorImpl extends BranchBuildStrategyDescriptor {
        public String getDisplayName() {
             return "Build tags from today";
        }
    }

}
