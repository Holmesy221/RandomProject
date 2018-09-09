package holmes.holmesy.randomproject;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class AttachmentDialog extends android.support.v4.app.DialogFragment {

    static final int REQUEST_IMAGE_CAPTURE = 1;

private Button mButton1, mButton2;

public AttachmentDialog(){}

public static AttachmentDialog newInstance(String title){
    AttachmentDialog dialog = new AttachmentDialog();
    Bundle args = new Bundle();
    args.putString("title", title);
    dialog.setArguments(args);
    return dialog;
}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_attachment_picker, container);


    }

    @Override

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Get field from view
        mButton1 = view.findViewById(R.id.buttonPicture);
        mButton2 = view.findViewById(R.id.buttonFilePicker);
        // Fetch arguments from bundle and set title
        String title = getArguments().getString("title", "Take picture or choose attachment");
        getDialog().setTitle(title);

        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePhoto();
            }
        });


        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fileExplorer();
            }
        });

    }


        private void fileExplorer(){

        }

        private void takePhoto(){
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (intent.resolveActivity(getActivity().getPackageManager())!= null){
                startActivity(intent);
            }

    }







}
