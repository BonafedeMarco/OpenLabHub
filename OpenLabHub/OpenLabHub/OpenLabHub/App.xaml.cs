using OpenLabHub.ViewModels;
using OpenLabHub.Views;
using Prism;
using Prism.Ioc;
using Prism.Navigation;
using Xamarin.Essentials;
using Xamarin.Essentials.Implementation;
using Xamarin.Essentials.Interfaces;
using Xamarin.Forms;

namespace OpenLabHub
{
    public partial class App
    {
        public App(IPlatformInitializer initializer) : base(initializer) { }

        protected override async void OnInitialized()
        {
            InitializeComponent();

            if (VersionTracking.IsFirstLaunchForCurrentVersion || VersionTracking.IsFirstLaunchEver)
                await NavigationService.NavigateAsync("/OnBoardingPage", useModalNavigation: false, animated: true);
            else
                await NavigationService.NavigateAsync("NavigationPage/SideMenuPage", useModalNavigation: false, animated: true);
        }

        protected override void RegisterTypes(IContainerRegistry containerRegistry)
        {
            containerRegistry.RegisterSingleton<IAppInfo, AppInfoImplementation>();

            containerRegistry.RegisterForNavigation<NavigationPage>();
            containerRegistry.RegisterForNavigation<MainPage, MainPageViewModel>();
            containerRegistry.RegisterForNavigation<OnBoardingPage, OnBoardingPageViewModel>();
            containerRegistry.RegisterForNavigation<LoginRegisterPage, LoginRegisterPageViewModel>();
            containerRegistry.RegisterForNavigation<ProfilePage, ProfilePageViewModel>();
            containerRegistry.RegisterForNavigation<ProjectDetailsPage, ProjectDetailsPageViewModel>();
            containerRegistry.RegisterForNavigation<SideMenuPage, SideMenuPageViewModel>();
        }
    }
}
