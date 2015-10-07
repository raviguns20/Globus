package primosurvey.com.primosurvey.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import primosurvey.com.primosurvey.R;
import primosurvey.com.primosurvey.models.ModelOptionsValue;
import primosurvey.com.primosurvey.models.ModelQuestion;

/**
 * Created by Laptop on 20-09-2015.
 */
public class AdapterDemo extends BaseAdapter {
    Context context;
    ArrayList<ModelQuestion>arrayList;
    LayoutInflater inflater;
    HashMap<String,ArrayList<String>>hashmap;
    ArrayList<ModelQuestion>modelQuestionReloadArrayList;


    public AdapterDemo(Context context, ArrayList<ModelQuestion> arrayList, HashMap<String, ArrayList<String>> hashmap) {
        this.context = context;
        this.arrayList = arrayList;
        this.hashmap = hashmap;
        inflater = LayoutInflater.from(context);
        modelQuestionReloadArrayList=new ArrayList<>();
        modelQuestionReloadArrayList.addAll(arrayList);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public View getView(final int position, View convertView,ViewGroup parent) {
        ViewHolders holder;
        final int i=position+1;
        final ArrayList<ModelOptionsValue> optionsValueArrayList = arrayList.get(position).getOptionValue();

        if (convertView == null) {
            holder = new ViewHolders();
            convertView = inflater.inflate(R.layout.demo_list_item, null);
            holder.linlayEdt= (LinearLayout) convertView.findViewById(R.id.listview_survey_question_item_surve_question_linlay_edt);
            holder.linlayRadio= (LinearLayout) convertView.findViewById(R.id.listview_survey_question_item_surve_question_linlay_radio);
            holder.txtQuestion = (TextView) convertView.findViewById(R.id.listview_survey_question_item_surve_question);
            holder.txtSrNo = (TextView) convertView.findViewById(R.id.listview_survey_question_item_surve_sr_no);
            TextView txtSrNo,txtQuestion;
            holder.radioGroup = (RadioGroup) convertView.findViewById(R.id.listview_survey_question_item_surve_question_radiogroup);
            holder.radioButtonOption1 = (RadioButton) convertView.findViewById(R.id.listview_survey_question_item_surve_question_radio_option1);
            holder.radioButtonOption2 = (RadioButton) convertView.findViewById(R.id.listview_survey_question_item_surve_question_radio_option2);
            holder.radioButtonOption3 = (RadioButton) convertView.findViewById(R.id.listview_survey_question_item_surve_question_radio_option3);
            holder.radioButtonOption4 = (RadioButton) convertView.findViewById(R.id.listview_survey_question_item_surve_question_radio_option4);
            holder.radioButtonOption5 = (RadioButton) convertView.findViewById(R.id.listview_survey_question_item_surve_question_radio_option5);
            holder. radioButtonOption6 = (RadioButton) convertView.findViewById(R.id.listview_survey_question_item_surve_question_radio_option6);
            holder. radioButtonOption7 = (RadioButton) convertView.findViewById(R.id.listview_survey_question_item_surve_question_radio_option7);
            holder.radioButtonOption8 = (RadioButton) convertView.findViewById(R.id.listview_survey_question_item_surve_question_radio_option8);
            holder.edtAnswer= (EditText) convertView.findViewById(R.id.listview_survey_question_item_surve_question_edt);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolders) convertView.getTag();
            holder.txtQuestion.setText("" + arrayList.get(position).getTitleEn());
            holder.txtSrNo.setText(i + ")");
            if (arrayList.get(position).getOptionType().equals("text")) {
                holder.linlayRadio.setVisibility(View.GONE);
                holder.linlayEdt.setVisibility(View.VISIBLE);
                holder.edtAnswer.setHint("Enter Answer");
                updateReceiptsList();
            }
            else {
                holder.linlayRadio.setVisibility(View.VISIBLE);
                holder.linlayEdt.setVisibility(View.GONE);

                if (optionsValueArrayList.size() == 8) {
                    holder.radioButtonOption1.setText("" + optionsValueArrayList.get(0).getOptionEn());
                    holder.radioButtonOption2.setText("" + optionsValueArrayList.get(1).getOptionEn());
                    holder.radioButtonOption3.setText("" + optionsValueArrayList.get(2).getOptionEn());
                    holder.radioButtonOption4.setText("" + optionsValueArrayList.get(3).getOptionEn());
                    holder.radioButtonOption5.setText("" + optionsValueArrayList.get(4).getOptionEn());
                    holder.radioButtonOption6.setText("" + optionsValueArrayList.get(5).getOptionEn());
                    holder.radioButtonOption7.setText("" + optionsValueArrayList.get(6).getOptionEn());
                    holder.radioButtonOption8.setText("" + optionsValueArrayList.get(7).getOptionEn());

                } else if (optionsValueArrayList.size() == 7) {
                    holder.radioButtonOption1.setText("" + optionsValueArrayList.get(0).getOptionEn());
                    holder.radioButtonOption2.setText("" + optionsValueArrayList.get(1).getOptionEn());
                    holder.radioButtonOption3.setText("" + optionsValueArrayList.get(2).getOptionEn());
                    holder.radioButtonOption4.setText("" + optionsValueArrayList.get(3).getOptionEn());
                    holder.radioButtonOption5.setText("" + optionsValueArrayList.get(4).getOptionEn());
                    holder.radioButtonOption6.setText("" + optionsValueArrayList.get(5).getOptionEn());
                    holder.radioButtonOption7.setText("" + optionsValueArrayList.get(6).getOptionEn());
                    holder.radioButtonOption8.setVisibility(View.GONE);
                } else if (optionsValueArrayList.size() == 6) {
                    holder.radioButtonOption1.setText("" + optionsValueArrayList.get(0).getOptionEn());
                    holder.radioButtonOption2.setText("" + optionsValueArrayList.get(1).getOptionEn());
                    holder.radioButtonOption3.setText("" + optionsValueArrayList.get(2).getOptionEn());
                    holder.radioButtonOption4.setText("" + optionsValueArrayList.get(3).getOptionEn());
                    holder.radioButtonOption5.setText("" + optionsValueArrayList.get(4).getOptionEn());
                    holder.radioButtonOption6.setText("" + optionsValueArrayList.get(5).getOptionEn());
                    holder.radioButtonOption7.setVisibility(View.GONE);
                    holder.radioButtonOption8.setVisibility(View.GONE);

                } else if (optionsValueArrayList.size() == 5) {
                    holder.radioButtonOption1.setText("" + optionsValueArrayList.get(0).getOptionEn());
                    holder.radioButtonOption2.setText("" + optionsValueArrayList.get(1).getOptionEn());
                    holder.radioButtonOption3.setText("" + optionsValueArrayList.get(2).getOptionEn());
                    holder.radioButtonOption4.setText("" + optionsValueArrayList.get(3).getOptionEn());
                    holder.radioButtonOption5.setText("" + optionsValueArrayList.get(4).getOptionEn());
                    holder.radioButtonOption6.setVisibility(View.GONE);
                    holder.radioButtonOption7.setVisibility(View.GONE);
                    holder.radioButtonOption8.setVisibility(View.GONE);

                    // radioButtonOption6.setText("" + optionsValueArrayList.get(5).getOptionEn());
                } else if (optionsValueArrayList.size() == 4) {
                    holder.radioButtonOption1.setText("" + optionsValueArrayList.get(0).getOptionEn());
                    holder.radioButtonOption2.setText("" + optionsValueArrayList.get(1).getOptionEn());
                    holder.radioButtonOption3.setText("" + optionsValueArrayList.get(2).getOptionEn());
                    holder.radioButtonOption4.setText("" + optionsValueArrayList.get(3).getOptionEn());
                    holder.radioButtonOption5.setVisibility(View.GONE);
                    holder.radioButtonOption6.setVisibility(View.GONE);
                    holder.radioButtonOption7.setVisibility(View.GONE);
                    holder.radioButtonOption8.setVisibility(View.GONE);

                    //radioButtonOption5.setText("" + optionsValueArrayList.get(4).getOptionEn());
                    //radioButtonOption6.setText("" + optionsValueArrayList.get(5).getOptionEn());
                } else if (optionsValueArrayList.size() == 3) {
                    holder.radioButtonOption1.setText("" + optionsValueArrayList.get(0).getOptionEn());
                    holder.radioButtonOption2.setText("" + optionsValueArrayList.get(1).getOptionEn());
                    holder.radioButtonOption3.setText("" + optionsValueArrayList.get(2).getOptionEn());
                    //radioButtonOption4.setText("" + optionsValueArrayList.get(3).getOptionEn());
                    holder.radioButtonOption4.setVisibility(View.GONE);
                    holder.radioButtonOption5.setVisibility(View.GONE);
                    holder.radioButtonOption6.setVisibility(View.GONE);
                    holder.radioButtonOption7.setVisibility(View.GONE);
                    holder.radioButtonOption8.setVisibility(View.GONE);

                } else if (optionsValueArrayList.size() == 2) {

                    holder.radioButtonOption1.setText("" + optionsValueArrayList.get(0).getOptionEn());
                    System.out.println("optionsValueArrayList.get(0).getOptionEn()" + optionsValueArrayList.get(1).getId());
                    holder.radioButtonOption2.setText("" + optionsValueArrayList.get(1).getOptionEn());

                    //   radioButtonOption3.setText("" + optionsValueArrayList.get(2).getOptionEn());
                    //radioButtonOption4.setText("" + optionsValueArrayList.get(3).getOptionEn());
                    holder.radioButtonOption3.setVisibility(View.GONE);
                    holder.radioButtonOption4.setVisibility(View.GONE);
                    holder.radioButtonOption5.setVisibility(View.GONE);
                    holder.radioButtonOption6.setVisibility(View.GONE);
                    holder.radioButtonOption7.setVisibility(View.GONE);
                    holder.radioButtonOption8.setVisibility(View.GONE);

                } else if (optionsValueArrayList.size() == 1) {
                    holder.radioButtonOption1.setText("" + optionsValueArrayList.get(0).getOptionEn());
                    holder.radioButtonOption2.setVisibility(View.GONE);
                    holder.radioButtonOption3.setVisibility(View.GONE);
                    holder.radioButtonOption4.setVisibility(View.GONE);
                    holder.radioButtonOption5.setVisibility(View.GONE);
                    holder.radioButtonOption6.setVisibility(View.GONE);
                    holder.radioButtonOption7.setVisibility(View.GONE);
                    holder.radioButtonOption8.setVisibility(View.GONE);
                }
            }
                holder.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                        int checkId=radioGroup.getCheckedRadioButtonId();
                        int  pos=radioGroup.indexOfChild(radioGroup.findViewById(checkedId));
                        Toast.makeText(context, "pos"+pos, Toast.LENGTH_SHORT).show();

                        if(checkId==R.id.listview_survey_question_item_surve_question_radio_option1) {
                            for (int i = 0; i < arrayList.size(); i++) {
                                arrayList.get(i).setFlag("0");
                            }
                            Toast.makeText(context, "chk 1", Toast.LENGTH_SHORT).show();
                            String id = optionsValueArrayList.get(pos).getId();
                            System.out.println("id for animal---" + id);
                            if (hashmap.containsKey(id)) {
                                ArrayList<String> arrayListsStrings = new ArrayList<String>();
                                arrayListsStrings = hashmap.get(id);
                                //System.out.println("id for animal---" + arrayListsStrings.get(0));
                                for (int i = 0; i < arrayListsStrings.size(); i++) {
                                    String ketString = arrayListsStrings.get(i);
                                    String[] keys = ketString.split(",");
                                    for (String animal : keys) {
                                        System.out.println("Animal---" + animal);
                                        for (int j = 0; j < arrayList.size(); j++) {
                                            if (arrayList.get(j).getId().equals(animal)) {
                                                arrayList.get(j).setFlag("1");

                                            } else {
                                                //arrayList.get(j).setFlag("0");
                                            }
                                        }
                                        updateReceiptsList();
                                    }
                                }

                            }
                        }
                        else if(checkId==R.id.listview_survey_question_item_surve_question_radio_option2) {
                            for (int i = 0; i < arrayList.size(); i++) {
                                arrayList.get(i).setFlag("0");
                            }

                            Toast.makeText(context, "chk 1", Toast.LENGTH_SHORT).show();
                            String id = optionsValueArrayList.get(pos).getId();
                            System.out.println("id for animal---" + id);
                            if (hashmap.containsKey(id)) {
                                ArrayList<String> arrayListsStrings = new ArrayList<String>();
                                arrayListsStrings = hashmap.get(id);
                                //System.out.println("id for animal---" + arrayListsStrings.get(0));
                                for (int i = 0; i < arrayListsStrings.size(); i++) {
                                    String ketString = arrayListsStrings.get(i);
                                    String[] keys = ketString.split(",");
                                    for (String animal : keys) {
                                        System.out.println("Animal---" + animal);
                                        for (int j = 0; j < arrayList.size(); j++) {
                                            if (arrayList.get(j).getId().equals(animal)) {
                                                arrayList.get(j).setFlag("1");

                                            } else {
                                                //arrayList.get(j).setFlag("0");
                                            }
                                        }
                                        updateReceiptsList();
                                    }
                                }

                            }
                        }

                        else
                        {
                            for (int i = 0; i < arrayList.size(); i++) {
                                arrayList.get(i).setFlag("0");
                            }

                        }
                    }
                });

        }
        if(arrayList.get(position).getFlag().equals("1"))
        {
            convertView.setVisibility(View.GONE);


        }
        else if(arrayList.get(position).getFlag().equals("0"))
        {
            convertView.setVisibility(View.VISIBLE);
        }

//        notifyDataSetChanged();
        return convertView;
    }

    public void updateReceiptsList() {

        notifyDataSetChanged();
    }
class ViewHolders
{
    RadioButton radioButtonOption1,radioButtonOption2,radioButtonOption3,radioButtonOption4,radioButtonOption5,radioButtonOption6,radioButtonOption7,radioButtonOption8;
    EditText edtAnswer;
    LinearLayout linlayEdt,linlayRadio;
RadioGroup radioGroup;
    TextView txtSrNo,txtQuestion;

}



}
