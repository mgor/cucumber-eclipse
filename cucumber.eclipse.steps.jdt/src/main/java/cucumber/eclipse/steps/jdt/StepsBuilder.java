package cucumber.eclipse.steps.jdt;

import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import cucumber.eclipse.steps.integration.StepDefinitions;
import cucumber.eclipse.steps.integration.StepsChangedEvent;

public class StepsBuilder extends IncrementalProjectBuilder {

	protected IProject[] build(int kind, @SuppressWarnings("rawtypes") Map args, IProgressMonitor monitor) throws CoreException {
		final StepDefinitions stepDefinitions = StepDefinitions.getInstance();
		if (stepDefinitions != null) {
			stepDefinitions.notifyListeners(new StepsChangedEvent());
		}

		return null;
	}
}
